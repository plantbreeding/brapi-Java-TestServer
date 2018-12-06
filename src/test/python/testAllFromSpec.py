#! /usr/bin/env python

import yaml
import sys
import os
import requests
from copy import deepcopy
import jsonschema
from jsonschema import validate
import dereferenceAll
import testInputs
import json
from jsonschema._utils import indent


def testPath(schema, path, method):
	url = baseURL + testInputs.replaceIDs(path)
	headers = {'Authorization':'Bearer YYYY', 'Accept': 'application/json'}
	if method == 'get':
		params = testInputs.getParams(path)
		res = requests.get(url, params, headers=headers)
	elif method == 'post' :
		params = testInputs.postParams(path)
		res = requests.post(url, json=params, headers=headers)
	elif method == 'put' :
		params = testInputs.putParams(path)
		res = requests.put(url, json=params, headers=headers)
	
	success = True
	error = ''
	example = {}
	try :
		example = res.json()
	except:
		success = False
		if verbose:
			error = 'Bad JSON\n' + method + ' ' + url + '\n' + str(res)
		else:
			error = 'X1 - ' + method + ' ' + url
	
	if not res.ok :
		success = False
		if verbose:
			error = 'Bad Response Code\n' + method + ' ' + url + '\n' + str(example)
		else:
			error = 'X2 - ' + method + ' ' + url
		
	try :
		if res.ok :
			validate(example, schema)
	except jsonschema.exceptions.ValidationError as ve:
		success = False
		if verbose:
			error = 'Bad Schema Match\n' + method + ' ' + url + '\n' + str(ve) + '\n' + json.dumps(example, indent = 4)
		else:
			error = 'X3 - ' + method + ' ' + url
	
	return success, error


def testPaths(obj):	
	if('paths' in obj):
		for path in obj['paths']:
			if (path.startswith(rootPath)):
				for method in obj['paths'][path]:
					for responseCode in obj['paths'][path][method]['responses']:
						if responseCode == '200' and 'content' in obj['paths'][path][method]['responses'][responseCode]:
							response = obj['paths'][path][method]['responses'][responseCode]['content']['application/json']
							if ('schema' in response):
								schema = deepcopy(response['schema'])
								success, error = testPath(schema, path, method)
								if not success :
									print(error)
						
	return obj



rootPath = '/'
verbose = False
baseURL = 'http://localhost:8080/brapi/v1'

if len(sys.argv) > 1 :
	rootPath += sys.argv[1];
if len(sys.argv) > 2 :
	verbose = sys.argv[2] == '-v';

print(rootPath)
brapi = dereferenceAll.dereferenceBrAPI('C:/Users/ps664/Documents/BrAPI/API/brapi_openapi.yaml')

testPaths(brapi)
	
	
