'''
Created on Apr 11, 2023

@author: ps664
'''

import sys
import os
import csv
import uuid
import struct
from datetime import datetime

STRING_HEX_PREFIX = "aced000574"
BOOL_HEX_PREFIX = "aced0005737200116a6176612e6c616e672e426f6f6c65616ecd207280d59cfaee0200015a000576616c75657870"
INT_HEX_PREFIX = "aced0005737200116a6176612e6c616e672e496e746567657212e2a0a4f781873802000149000576616c7565787200106a6176612e6c616e672e4e756d62657286ac951d0b94e08b0200007870"
DOUBLE_HEX_PREFIX = "aced0005737200106a6176612e6c616e672e446f75626c6580b3c24a296bfb0402000144000576616c7565787200106a6176612e6c616e672e4e756d62657286ac951d0b94e08b0200007870"

INSERT_VARIANTSET = "INSERT INTO variantset (auth_user_id, id, variant_set_name, reference_set_id, study_id) VALUES('anonymousUser', '{variantSetId}', '{variantSetName}', 'reference_set1', '{studyId}');\n"
INSERT_VARIANTSET_FORMAT = "INSERT INTO variantset_format (id, data_format, file_format, fileurl, variant_set_id) VALUES('{formatId}', {dataFormat}, {fileType}, '{formatURL}', '{variantSetId}');\n"

INSERT_VARIANT = "INSERT INTO variant (id, auth_user_id, created, variant_end, filters_applied, filters_passed, reference_bases, variant_start, svlen, updated, variant_name, variant_type, variant_set_id) VALUES('{variantId}', 'anonymousUser', '{created}', {variant_end}, false, false, '{reference_bases}', {variant_start}, {len}, '{created}', '{variant_name}', 'SNP', '{variantSetId}');   \nINSERT INTO variant_entity_alternate_bases(variant_entity_id, alternate_bases) VALUES('{variantId}', '{alternate_bases}');\n"
INSERT_VARIANT_ADDL = "INSERT INTO additional_info(id, key, value) VALUES ('{additional_info_id}', '{key}', decode('{value}','hex'));\nINSERT INTO variant_additional_info(variant_entity_id, additional_info_id) VALUES ('{variantId}', '{additional_info_id}');\n"

INSERT_PLATE = "INSERT INTO plate (auth_user_id, id, client_plate_db_id, client_plate_barcode, plate_name, plate_barcode, plate_format, sample_type, sample_submission_format, status_time_stamp, program_id, trial_id, study_id) VALUES('anonymousUser', '{plateId}', '{plateId}', '{plateId}', '{plateName}', '{plateId}', 0, 0, 0, '{date}', 'program2', 'trial2', '{studyId}');\n"
INSERT_GERMPLASM = "INSERT INTO germplasm (auth_user_id, id, accession_number, acquisition_date, acquisition_source_code, biological_status_of_accession_code, collection, country_of_origin_code, default_display_name, documentationurl, germplasm_name, germplasmpui, breeding_method_id, crop_id) VALUES('anonymousUser', '{germplasmId}', 'A{germplasmId}', '2000-04-09', 2, 2, 'Fake Foods Collection', 'USA', '{germplasmName}', 'https://brapi.org', '{germplasmName}', 'doi:10.12345/A{germplasmId}', 'breeding_method1', '1');\n"
INSERT_SAMPLE = "INSERT INTO sample (auth_user_id, id, plate_column, plate_row, sample_barcode, sample_description, sample_group_db_id, sample_name, samplepui, sample_timestamp, sample_type, tissue_type, volume, well, plate_id) VALUES('anonymousUser', '{sampleId}', {colNum}, '{rowStr}', '{sampleId}', 'This is a description of a fake sample. This sample is fake.', 'DArT Group 1', '{sampleName}', 'doi://10.12345/fake/{sampleId}', '{date}', 'DNA', 'Leaf', '{volume}', '{well}', '{plateId}');\n"
INSERT_CALLSET = "INSERT INTO callset (auth_user_id, id, call_set_name, created, updated, sample_id) VALUES('anonymousUser', '{callsetId}', '{callsetName}', '{date}', '{date}', '{sampleId}');\nINSERT INTO callset_variant_sets (call_sets_id, variant_sets_id) VALUES('{callsetId}', '{variantSetId}');\n"

INSERT_ALLELE_CALL = "INSERT INTO allele_call(auth_user_id, id, genotype, variant_id, call_set_id) VALUES('anonymousUser', '{callId}', '{genotype}', '{variantId}','{callsetId}');\n"

def doubleToHex(num):
    return DOUBLE_HEX_PREFIX + struct.pack('!d', num).hex()

def stringToHex(str):
    if(str.isdigit()):
        return intToHex(int(str))
    if(str.replace('.', '').isdigit()):
        return doubleToHex(float(str))
    
    return STRING_HEX_PREFIX + struct.pack('!i', len(str)).hex()[-4:] + bytes(str, 'utf-8').hex()

def intToHex(int):
    return INT_HEX_PREFIX + bytes(int).hex()

def boolToHex(bool):
    if bool:
        return BOOL_HEX_PREFIX + '01'
    else:
        return BOOL_HEX_PREFIX + '00'


def generateContextSQL(outPath):
    print(outPath)
    context = dict(variantSetId = "variantset_dartseq_001", 
                   variantSetName = "DArTSeq Dummy VariantSet 1", 
                   studyId = "study3")
    
    sqlString = INSERT_VARIANTSET.format(**context)
    
    formatData = dict(
        formatId = str(uuid.uuid4())[-12:],
        dataFormat = 4,
        fileType = 0,
        formatURL = "https://test-server.brapi.org/brapi/v2/allelematrix?variantSetDbId=" + context["variantSetId"],
        variantSetId = context["variantSetId"]
    )
    
    sqlString += INSERT_VARIANTSET_FORMAT.format(**formatData)
    
    formatData = dict(
        formatId = str(uuid.uuid4())[-12:],
        dataFormat = 0,
        fileType = 1,
        formatURL = "https://test-server.brapi.org/brapi/v2/docs/VariantSet_4_DartSeq.csv",
        variantSetId = context["variantSetId"]
    )
    
    sqlString += INSERT_VARIANTSET_FORMAT.format(**formatData)
    
    formatData = dict(
        formatId = str(uuid.uuid4())[-12:],
        dataFormat = 2,
        fileType = 2,
        formatURL = "https://test-server.brapi.org/brapi/v2/docs/Variant_4_Hapmap.tsv",
        variantSetId = context["variantSetId"]
    )
    
    sqlString += INSERT_VARIANTSET_FORMAT.format(**formatData)
    
    
    
    sqlString += '\n\n\n'
    
    fileName = outPath + 'variant_set_4.sql'
    with open(fileName, 'w') as outfile:
            outfile.write(sqlString)
            print("fileName - " + fileName)
    
    return context

def generateVariantSQL(context, outPath, variantsCSVPath):
    sqlString = ""
    context['variantIds'] = []
    now = datetime.now().isoformat()
    
    with open(variantsCSVPath, newline='') as variantsCSVPath:
        matrixReader = csv.DictReader(variantsCSVPath, delimiter=',', quoting=csv.QUOTE_NONE)
        for row in matrixReader:
            id = str(uuid.uuid4())[-12:]
            context['variantIds'].append(id)
            
            variantData = dict( 
                variantId=id, 
                created=now,
                reference_bases = row['alleles'][0], 
                alternate_bases = row['alleles'][2],
                variant_start= int(row['ClusterTempIndex']) + int(row['SnpPosition']),
                variant_end = int(row['ClusterTempIndex']) + int(row['SnpPosition']) + 1,
                len = 1, 
                variant_name= row['AlleleID'],
                variantSetId= context['variantSetId']
            )
            
            sqlString += INSERT_VARIANT.format(**variantData)
            # for key in row.keys():
            additionalInfo = dict(
                additional_info_id = str(uuid.uuid4())[-12:],
                key = 'SNP',
                value = stringToHex(row['SNP']),
                variantId = id
                )
            
            sqlString += INSERT_VARIANT_ADDL.format(**additionalInfo)
                
            sqlString += '\n'
    sqlString += '\n\n\n'
    
    fileName = outPath + 'variant_set_4.sql'
    with open(fileName, 'a') as outfile:
            outfile.write(sqlString)
            print("fileName - " + fileName)
    
def generateSampleSQL(context, outPath, samplesCSVPath):
    sqlString = ""
    context['callsetIds'] = []
    now = datetime.now().isoformat()
    germplasmMap = {}
    plateMap = {} 
    
    with open(samplesCSVPath, newline='') as samplesCSV:
        matrixReader = csv.DictReader(samplesCSV, delimiter=',', quoting=csv.QUOTE_NONE)
        for row in matrixReader:            
            plateId = ''
            if(row['plate'] in plateMap):
                plateId = plateMap[row['plate']]
            else:
                plateId = str(uuid.uuid4())[-12:]
                plateMap[row['plate']] = plateId
            
                plateData = dict( 
                    plateId=plateId,
                    plateName= "Plate_" + row['plate'],
                    date=now,
                    studyId = context['studyId'], 
                )
                sqlString += INSERT_PLATE.format(**plateData)
        
        
            germplasmId = ''
            if(row['germplasm'] in germplasmMap):
                germplasmId = germplasmMap[row['germplasm']]
            else:
                germplasmId = str(uuid.uuid4())[-12:]
                germplasmMap[row['germplasm']] = germplasmId
            
                germplasmData = dict( 
                    germplasmId=germplasmId,
                    germplasmName= row['germplasm']
                )
                sqlString += INSERT_GERMPLASM.format(**germplasmData)
        
        
            sampleId = str(uuid.uuid4())[-12:]
            sampleData = dict( 
                sampleId = sampleId,
                sampleName = "Sample_" + row['sampleName'],
                colNum = row['well'][1:],
                rowStr = row['well'][1],
                date = now,
                volume = row['volume'],
                well = row['well'],
                plateId = plateId
            )
            sqlString += INSERT_SAMPLE.format(**sampleData)
            
            
            callsetId = str(uuid.uuid4())[-12:]
            context['callsetIds'].append(callsetId)
            callsetData = dict( 
                callsetId = callsetId,
                sampleId = sampleId,
                callsetName = row['sampleName'],
                date = now,
                variantSetId= context['variantSetId']
            )
            sqlString += INSERT_CALLSET.format(**callsetData)
            
            sqlString += '\n'
    sqlString += '\n\n\n'
    
    fileName = outPath + 'variant_set_4.sql'
    with open(fileName, 'a') as outfile:
            outfile.write(sqlString)
            print("fileName - " + fileName)
    
def generateMatrixSQL(context, outPath, dartseqCSVPath):    
    with open(dartseqCSVPath, newline='') as dartseqCSV:
        fileName = outPath + 'variant_set_4_alleles.sql'
        outfile = open(fileName, 'w')
        
        matrixReader = csv.reader(dartseqCSV, delimiter=',', quoting=csv.QUOTE_NONE)
        matrixReader.__next__()
        
        for variantIndex, row in enumerate(matrixReader):
            if( variantIndex >= 1):
                sqlString = ''
                for callsetIndex, value in enumerate(row):
                    if( callsetIndex >= 1):
                        if(value != '-'):
                            gt = ''                            
                            if value == '0':
                                gt = '0/0'
                            elif value == '1':
                                gt = '1/1'
                            elif value == '2':
                                gt = '0/1'
                                
                            callData = dict( 
                                callId = str(uuid.uuid4())[-12:],
                                callsetId = context['callsetIds'][callsetIndex - 1],
                                genotype = gt,
                                variantId = context['variantIds'][variantIndex - 1]
                            )
                            sqlString += INSERT_ALLELE_CALL.format(**callData)
                
                print(variantIndex)
                outfile.write(sqlString)
                outfile.flush()

    sqlString = '\n\n\n'
    outfile.write(sqlString)
    outfile.close()
    print("fileName - " + fileName)
    
    
    


outPath = './out/'
variantsCSVPath = './variants.csv'
samplesCSVPath = './samples.csv'
dartseqCSVPath = './dartseq.csv'
verbose = False

verbose = '-v' in sys.argv 

if '-variants' in sys.argv:
    bi = sys.argv.index('-variants')
    variantsCSVPath = sys.argv[bi + 1]

if '-samples' in sys.argv:
    si = sys.argv.index('-samples')
    samplesCSVPath = sys.argv[si + 1]
    
if '-dartseq' in sys.argv:
    di = sys.argv.index('-dartseq')
    dartseqCSVPath = sys.argv[di + 1]

if '-out' in sys.argv:
    ri = sys.argv.index('-out')
    outPath = sys.argv[ri + 1]
    
if outPath[-1] != '/':
    outPath = outPath + '/'


context = generateContextSQL(outPath)
generateVariantSQL(context, outPath, variantsCSVPath)
generateSampleSQL(context, outPath, samplesCSVPath)
generateMatrixSQL(context, outPath, dartseqCSVPath)

