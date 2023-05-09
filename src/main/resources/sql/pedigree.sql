INSERT INTO pedigree_node (auth_user_id, id, crossing_year, family_code, pedigree_string, crossing_project_id, germplasm_id) VALUES('anonymousUser', 'pedigree1', 2000, 'FAKEFAM', 'A2342345/A1231234', 'crossing_project1', 'germplasm1');
INSERT INTO pedigree_node (auth_user_id, id, crossing_year, family_code, pedigree_string, crossing_project_id, germplasm_id) VALUES('anonymousUser', 'pedigree2', 2001, 'FAKEFAM', 'A2342345/A4564565', 'crossing_project1', 'germplasm2');
INSERT INTO pedigree_node (auth_user_id, id, crossing_year, family_code, pedigree_string, crossing_project_id, germplasm_id) VALUES('anonymousUser', 'pedigree3', 2002, 'FAKEFAM', 'A0000001/A0000002', 'crossing_project1', 'germplasm3');

INSERT INTO pedigree_edge (id, edge_type, parent_type, this_node_id, connceted_node_id) VALUES('p1_parent_p3',  0, 0,    'pedigree3', 'pedigree1');
INSERT INTO pedigree_edge (id, edge_type, parent_type, this_node_id, connceted_node_id) VALUES('p3_child_p1',   1, 0,    'pedigree1', 'pedigree3');
INSERT INTO pedigree_edge (id, edge_type, parent_type, this_node_id, connceted_node_id) VALUES('p2_parent_p3',  0, 1,    'pedigree3', 'pedigree2');
INSERT INTO pedigree_edge (id, edge_type, parent_type, this_node_id, connceted_node_id) VALUES('p3_child_p2',   1, 1,    'pedigree2', 'pedigree3');
INSERT INTO pedigree_edge (id, edge_type, parent_type, this_node_id, connceted_node_id) VALUES('p1_sibling_p2', 2, null, 'pedigree1', 'pedigree2');
INSERT INTO pedigree_edge (id, edge_type, parent_type, this_node_id, connceted_node_id) VALUES('p2_sibling_p1', 2, null, 'pedigree2', 'pedigree1');
