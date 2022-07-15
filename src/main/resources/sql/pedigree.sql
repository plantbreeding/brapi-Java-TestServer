INSERT INTO pedigree_node (auth_user_id, id, crossing_year, family_code, pedigree_string, crossing_project_id, germplasm_id) VALUES('anonymousUser', 'pedigree1', 2000, 'FAKEFAM', 'A2342345/A1231234', 'crossing_project1', 'germplasm1');
INSERT INTO pedigree_node (auth_user_id, id, crossing_year, family_code, pedigree_string, crossing_project_id, germplasm_id) VALUES('anonymousUser', 'pedigree2', 2001, 'FAKEFAM', 'A2342345/A4564565', 'crossing_project1', 'germplasm2');
INSERT INTO pedigree_node (auth_user_id, id, crossing_year, family_code, pedigree_string, crossing_project_id, germplasm_id) VALUES('anonymousUser', 'pedigree3', 2002, 'FAKEFAM', 'A0000001/A0000002', 'crossing_project1', 'germplasm3');

INSERT INTO pedigree_edge (id, parent_type, parent_node_id, child_node_id, sibling_node_id, connceted_node_id) VALUES('p1_parent_p3', 0, null, 'pedigree1', null, 'pedigree3');
INSERT INTO pedigree_edge (id, parent_type, parent_node_id, child_node_id, sibling_node_id, connceted_node_id) VALUES('p2_parent_p3', 1, null, 'pedigree2', null, 'pedigree3');
INSERT INTO pedigree_edge (id, parent_type, parent_node_id, child_node_id, sibling_node_id, connceted_node_id) VALUES('p3_child_p1', 0, 'pedigree3', null, null, 'pedigree1');
INSERT INTO pedigree_edge (id, parent_type, parent_node_id, child_node_id, sibling_node_id, connceted_node_id) VALUES('p3_child_p2', 1, 'pedigree3', null, null, 'pedigree2');
INSERT INTO pedigree_edge (id, parent_type, parent_node_id, child_node_id, sibling_node_id, connceted_node_id) VALUES('p1_sibling_p2', null, null, null, 'pedigree1', 'pedigree2');
INSERT INTO pedigree_edge (id, parent_type, parent_node_id, child_node_id, sibling_node_id, connceted_node_id) VALUES('p2_sibling_p1', null, null, null, 'pedigree2', 'pedigree1');
