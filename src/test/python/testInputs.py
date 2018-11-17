#! /usr/bin/env python

import yaml
import glob
import sys
import json
import requests
from copy import deepcopy
import jsonschema
from jsonschema import validate
import dereferenceAll


def replaceIDs(url):
	newURL = url
	newURL = newURL.replace('{studyDbId}', '1001')
	newURL = newURL.replace('{mapDbId}', 'gm1')
	newURL = newURL.replace('{breedingMethodDbId}', 'bm1')
	newURL = newURL.replace('{germplasmDbId}', '3')
	newURL = newURL.replace('{locationDbId}', '1')
	newURL = newURL.replace('{observationVariableDbId}', 'MO_123:100002')
	newURL = newURL.replace('{traitDbId}', 't1')
	newURL = newURL.replace('{trialDbId}', '101')
	newURL = newURL.replace('{markerDbId}', 'mr02')
	newURL = newURL.replace('{markerProfileDbId}', 'P1')
	newURL = newURL.replace('{linkageGroupName}', '1')
	newURL = newURL.replace('{sampleDbId}', 'sam1')
	newURL = newURL.replace('{vendorPlateDbId}', 'pl1')
	newURL = newURL.replace('{imageDbId}', 'img1')
	newURL = newURL.replace('{listDbId}', 'list1')
	newURL = newURL.replace('{personDbId}', 'person1')
	newURL = newURL.replace('{methodDbId}', 'm1')
	newURL = newURL.replace('{scaleDbId}', 's1')
	newURL = newURL.replace('{traitDbId}', 't1')
	return newURL


def postParams(path):
	params = {'pageSize': 2}
	if path == '/vendor/plates':
		params = {
		  "plates": [
		    {
		      "clientPlateDbId": "string",
		      "plateFormat": "string",
		      "sampleType": "string",
		      "samples": [
		        {
		          "column": "1",
		          "concentration": "string",
		          "row": "0",
		          "sampleDbId": "string",
		          "taxonId": {
		            "sourceName": "string",
		            "taxonId": "string"
		          },
		          "tissueType": "string",
		          "volume": "string",
		          "well": "1"
		        }
		      ],
		      "vendorProjectDbId": "string"
		    }
		  ]
		}
	elif path == '/phenotypes':
		params = {
		  "data": [
		    {
		      "observatioUnitDbId": "1",
		      "observations": [
		        {
		          "collector": "string",
		          "observationDbId": "string",
		          "observationTimeStamp": "2018-09-19T15:57:27.903Z",
		          "observationVariableDbId": "MO_123:100002",
		          "observationVariableName": "string",
		          "season": "fall 2011",
		          "value": "string"
		        }
		      ],
		      "studyDbId": "string"
		    }
		  ]
		}
	elif path == '/markers-search' : 
		params['includeSynonyms'] = 'true'
	elif path == '/images':
		params = {
				  "copyright": "Copyright 2019",
				  "description": "BrAPI Logo",
				  "descriptiveOntologyTerms": [ "brapi", "logo" ],
				  "imageFileName": "brapi-logo.svg",
				  "imageFileSize": 3676,
				  "imageHeight": 56,
				  "imageName": "brapiLogo",
				  "imageWidth": 258,
				  "mimeType": "image/svg",
				  "observationDbIds": [ "1", "2" ],
				  "observationUnitDbId": "1",
				  "imageLocation": {
					                    "geometry": {
					                        "type": "Point",
					                        "coordinates": [
					                            - 110.11301,
					                            50.010082
					                        ]
					                    },
					                    "type": "Feature"
					                },
				  "imageTimeStamp": "2011-06-14",
				  "imageURL": "https://brapi.org/assets/images/brapi-logo.svg"
				}
	elif path == '/lists':
		params = {
				  "data": [
				    "string"
				  ],
				  "description": "string",
				  "listName": "string",
				  "listOwnerName": "string",
				  "listOwnerPersonDbId": "string",
				  "listSize": 0,
				  "listSource": "string",
				  "listType": "germplasm"
				}
	elif path == '/lists/{listDbId}/items':
		params = ["1", "2", "3"]
	elif path == '/people':
		params = {
				  "description": "string",
				  "emailAddress": "string",
				  "firstName": "Name",
				  "lastName": "Smith",
				  "mailingAddress": "string",
				  "middleName": "string",
				  "phoneNumber": "string",
				  "userID": "string"
				}
		 
	return params


def putParams(path):
	params = {'pageSize': 2}
	if path == '/samples':
		params = {
		  "germplasmDbId": "1",
		  "notes": "string",
		  "observationUnitDbId": "1",
		  "plantDbId": None,
		  "plateDbId": "string",
		  "plateIndex": 0,
		  "plotDbId": "1",
		  "sampleDbId": "string",
		  "sampleTimestamp": "2018-09-25T21:07:17.505Z",
		  "sampleType": "string",
		  "studyDbId": "1001",
		  "takenBy": "string",
		  "tissueType": "string"
		}
	elif path == '/studies/{studyDbId}/layout':
		params = {
		  "layout": [
		    {
		      "X": 10,
		      "Y": 12,
		      "blockNumber": 0,
		      "entryType": "CHECK",
		      "observationUnitDbId": "1",
		      "replicate": 0
		    }
		  ]
		}
	elif path == '/studies/{studyDbId}/observationunits':
		params = [{}]
	elif path == '/images/{imageDbId}':
		params = {
				  "copyright": "Copyright 2019",
				  "description": "BrAPI Logo",
				  "descriptiveOntologyTerms": [ "brapi", "logo" ],
				  "imageFileName": "brapi-logo.svg",
				  "imageFileSize": 3676,
				  "imageHeight": 56,
				  "imageName": "brapiLogo",
				  "imageWidth": 258,
				  "mimeType": "image/svg",
				  "observationDbIds": [ "1", "2" ],
				  "observationUnitDbId": "1",
				  "imageLocation": {
					                    "geometry": {
					                        "type": "Point",
					                        "coordinates": [
					                            - 110.11301,
					                            50.010082
					                        ]
					                    },
					                    "type": "Feature"
					                },
				  "imageTimeStamp": "2011-06-14",
				  "imageURL": "https://brapi.org/assets/images/brapi-logo.svg"
				}
	elif path == '/lists/{listDbId}':
		params = {
				  "data": [
				    "string"
				  ],
				  "description": "string",
				  "listName": "string",
				  "listOwnerName": "string",
				  "listOwnerPersonDbId": "string",
				  "listSize": 0,
				  "listSource": "string",
				  "listType": "germplasm"
				}
	elif path == '/people/{personDbId}':
		params = {
				  "description": "string",
				  "emailAddress": "string",
				  "firstName": "Name",
				  "lastName": "Nameson",
				  "mailingAddress": "string",
				  "middleName": "string",
				  "phoneNumber": "string",
				  "userID": "string"
				}
		
	return params


def getParams(path):
	params = {'pageSize': 2}
	if path == '/markers-search' : 
		params['includeSynonyms'] = 'true'
	elif path == '/markers':
		params['include'] = 'synonyms'
	elif path == '/germplasm/{germplasmDbId}/pedigree':
		params['includeSiblings'] = 'true'
	return params
