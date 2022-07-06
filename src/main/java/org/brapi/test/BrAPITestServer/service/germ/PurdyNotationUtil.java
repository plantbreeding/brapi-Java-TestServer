package org.brapi.test.BrAPITestServer.service.germ;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PurdyNotationUtil {


	private final static Pattern tokenizeRegex = Pattern.compile("(?:(?<sep>\\/\\d+\\/|\\/{1,2})?(?<val>[^\\/]+))");
	
	public static PurdyNode parsePurdy(String purdy) {
		PurdyNode root = new PurdyNode(purdy);		
		buildTree(root);
		return root;
	}
	
	private static void buildTree(PurdyNode node) {
		Matcher matcher = tokenizeRegex.matcher(node.getPedigreeString());
		List<String> tokens = new ArrayList<>();
		
		while(matcher.find()) {
			String sep = matcher.group("sep");
			if(sep != null)
				tokens.add(sep);
			
			String val = matcher.group("val");
			if(val != null)
				tokens.add(val);
		}

		int maxSepIndex = 0;
		int maxSepDepth = 0;
		for(int i = 0; i < tokens.size(); i++) {
			String token = tokens.get(i);
			int sepDepth = -1;
			if(token.equals("/"))
				sepDepth = 1;
			else if(token.equals("//"))
				sepDepth = 2;
			else if(token.startsWith("/")) {
				String num = token.replaceAll("/", "");
				sepDepth = Integer.parseInt(num);
			}
			
			if(sepDepth >= maxSepDepth) {
				maxSepDepth = sepDepth;
				maxSepIndex = i;
			}
		}

		if(maxSepDepth > 0) {
			String parent1Name = String.join("", tokens.subList(0, maxSepIndex));
			PurdyNode parent1 = new PurdyNode(parent1Name);
			node.setParent1(parent1);
			buildTree(parent1);

			String parent2Name = String.join("", tokens.subList(maxSepIndex+1, tokens.size()));
			PurdyNode parent2 = new PurdyNode(parent2Name);
			node.setParent2(parent2);
			buildTree(parent2);
		}	
	}
}
