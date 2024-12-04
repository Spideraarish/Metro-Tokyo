import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MapRepresentation  {
	private Map<Node,Double> map;
	private Node previousNode;
	private static ArrayList<Node> visited;
	private static ArrayList<String> minimumPath; 
	private static ArrayList<Node> minimumPathCondensed;

	public MapRepresentation() {
		map = new HashMap<Node,Double>();
		visited = new ArrayList<Node>();
		minimumPath = new ArrayList<String>();
		minimumPathCondensed = new ArrayList<Node>();
	}

	public  void shortestPath(Node origin, Node destination) {
		if (origin == null || destination == null) {
			throw new IllegalArgumentException("Origin and destination nodes cannot be null");
		}
		if(origin.equals(destination)) {
			minimumPath.add(origin.getStation());
			minimumPathCondensed.add(origin);
		}else {
			List<Edge> connections = origin.getEdges();
			double currDistance = 0;
			minimumPath.add(0, origin.getStation());
			visited.add(origin);
			for (int i=0;i<connections.size();i++) {
				Node currDestination = connections.get(i).getDestination();
				if(!visited.contains(currDestination)) {
					currDistance = connections.get(i).getDistance() + distanceCoord(connections.get(i).getDestination().getLatitude(), 
							connections.get(i).getDestination().getLongitude(), destination.getLatitude(), destination.getLongitude());
					if(previousNode != null && !(currDestination.getLines() % 2 == 0 && previousNode.getLines() % 2 ==0 || 
							currDestination.getLines() % 3 == 0 && previousNode.getLines() % 3 == 0 || 
							currDestination.getLines() % 5 == 0 && previousNode.getLines() % 5 == 0)) {
						currDistance += 2;
					}
					map.put(connections.get(i).getDestination(), currDistance);
				}
			}
			double shortestDistance = 500;
			double tempDistance;
			Node nearestNode = null;
			for(Map.Entry<Node, Double> entry : map.entrySet()) {
				tempDistance = entry.getValue();
				if(tempDistance < shortestDistance) {
					shortestDistance = tempDistance;
					nearestNode = entry.getKey();
				}
			}
			minimumPath.add(nearestNode.getStation());
			map.remove(nearestNode);
			previousNode = origin;
			if(!nearestNode.equals(destination)) {
				shortestPath(nearestNode,destination);
				return;
			}
			List<Edge> pathEdges = new ArrayList<Edge>();
			Node lastPathNode;
			minimumPathCondensed.add(destination);
			lastPathNode = destination;
			for(int pn = visited.size()-1; pn >= 0; pn--) {			
				pathEdges = lastPathNode.getEdges();
				for(int arg = 0; arg < pathEdges.size(); arg++) {
					if(pathEdges.get(arg).getDestination().equals(visited.get(pn))) {
						lastPathNode = visited.get(pn);
						minimumPathCondensed.add(visited.get(pn));
					}
				}
			}
		}
	}

	public double distanceCoord(double lat1, double lng1, double lat2, double lng2) {  
		if (lat1 == 0 || lng1 == 0 || lat2 == 0 || lng2 == 0) {
			throw new IllegalArgumentException("Invalid coordinates: cannot be zero");
		}
		double earthRadius = 6371;
		double latitudeDifference = Math.toRadians(lat2 - lat1);  
		double longitudeDifference = Math.toRadians(lng2 - lng1);  
		double sindLat = Math.sin(latitudeDifference / 2);  
		double sindLng = Math.sin(longitudeDifference / 2);  
		double va1 = Math.pow(sindLat, 2) + Math.pow(sindLng, 2) * 
				Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2));  
		double va2 = 2 * Math.atan2(Math.sqrt(va1), Math.sqrt(1 - va1));  
		double finalDistance = earthRadius * va2;  

		return finalDistance;
	}

	public static Graph getStations() {
		// Green Line Stations 2
		Node ikebukuro = new Node("Ikebukuro", 35.729668, 139.710900, 66);
		Node higashiShinjuku = new Node("Higashi-Shinjuku", 35.695891, 139.707159, 10);
		Node mejiroJingumae = new Node("Meiji-Jingumae", 35.669, 139.702, 2);
		Node shinjukuSanchome = new Node("Shinjuku-Sanchome", 35.693, 139.703, 6);

		// Red Line Stations 3
		Node shinjuku = new Node("Shinjuku", 35.690, 139.700, 3);
		Node nishiShinjuku = new Node("Nishi-Shinjuku", 35.688, 139.694, 30);
		Node akasakaMitsuke = new Node("Akasaka-Mitsuke", 35.675, 139.736, 3);
		Node kasumigaseki = new Node("Kasumigaseki", 35.678, 139.742, 3);
		Node otemachi = new Node("Otemachi", 35.687, 139.763, 3);
		Node ginza = new Node("Ginza", 35.676, 139.763, 21);
		Node tokyo = new Node("Tokyo", 35.681, 139.766, 33);
		Node hongoSanchome = new Node("Hongo-Sanchome", 35.707, 139.766, 15);
		Node korakuen = new Node("Korakuen", 35.708, 139.751, 3);

		// yellow line stations 5
		Node tochomae = new Node("Tochomae", 35.692, 139.692, 5);
		Node shinjukuNishiguchi = new Node("Shinjuku-nishiguchi", 35.690, 139.698, 5);		
		Node aoyamaItchome = new Node("Aoyama-itchome", 35.678, 139.724, 35);
		Node roppongi = new Node("Roppongi", 35.664, 139.731, 5);
		Node akabanebashi = new Node("Akabanebashi", 35.653, 139.746, 5);
		Node daimon = new Node("Daimon", 35.656, 139.756, 5);
		Node shidome = new Node("Shidome", 35.665, 139.759, 5);
		Node tsukijishijo = new Node("Tsukujishijo", 35.667, 139.772, 5);
		Node tsukishima = new Node("Tsukishima", 35.661, 139.783, 5);
		Node kiyosumShirakawa = new Node("Kiyosumi-shirakawa", 35.678, 139.800, 5);
		Node ryogoku = new Node("Ryogoku", 35.696, 139.794, 5);
		Node uenoOkachimachi = new Node("Ueno-okachimachi", 35.707, 139.772, 55);
		Node kasuga = new Node("Kasuga", 35.707, 139.752, 5);
		
		//Blue line stations 7
		Node shimbashi = new Node("Shimbashi", 35.666, 139.758, 77);
		Node shibuya = new Node("Shibuya", 35.659, 139.701, 144);
		Node omoteSando = new Node("Omote-Sando", 35.665, 139.712, 7);
		Node ueno = new Node("Ueno", 35.712, 139.778, 77);
		Node asakusa = new Node("Asakusa", 35.711, 139.798, 7);
		Node uenoHirokoji = new Node("Ueno-hirokoji", 35.707, 139.771, 7);
		Node suehirocho = new Node("Suehirocho", 35.706, 139.772, 7);
		Node kanda = new Node("Kanda", 35.692, 139.772, 7);
		Node mitsukoshimae = new Node("Mitsukoshimae", 35.686, 139.780, 7);

		// Purple Line Stations 11
		Node ebisu = new Node("Ebisu", 35.646, 139.710, 11);
		Node akihabara = new Node("Akihabara", 35.698, 139.774, 11);
		Node nippori = new Node("Nippori", 35.732, 139.771, 11);
	 
		
		shinjuku.addEdge(new Edge(shinjuku, nishiShinjuku,0.5 ));
		nishiShinjuku.addEdge(new Edge(nishiShinjuku,shinjuku,0.5 ));

		shinjuku.addEdge(new Edge(shinjuku, shinjukuSanchome,0.650 ));
		shinjukuSanchome.addEdge(new Edge(shinjukuSanchome, shinjuku,0.650 ));

		shinjukuSanchome.addEdge(new Edge(shinjukuSanchome, higashiShinjuku, 1.2));
		higashiShinjuku.addEdge(new Edge(higashiShinjuku,shinjukuSanchome, 1.2));

		higashiShinjuku.addEdge(new Edge(higashiShinjuku, ikebukuro, 3.5));
		ikebukuro.addEdge(new Edge(ikebukuro, higashiShinjuku, 3.5));

		shinjukuSanchome.addEdge(new Edge(shinjukuSanchome, mejiroJingumae, 1.5));
		mejiroJingumae.addEdge(new Edge(mejiroJingumae,shinjukuSanchome, 1.5));

		shinjukuSanchome.addEdge(new Edge(shinjukuSanchome, akasakaMitsuke,1.3 ));
		akasakaMitsuke.addEdge(new Edge(akasakaMitsuke, shinjukuSanchome,1.3 ));

		akasakaMitsuke.addEdge(new Edge(akasakaMitsuke,kasumigaseki,0.8));
		kasumigaseki.addEdge(new Edge(kasumigaseki,akasakaMitsuke,0.8));

		kasumigaseki.addEdge(new Edge(kasumigaseki, ginza, 1.1));
		ginza.addEdge(new Edge(ginza, kasumigaseki, 1.1));

		ginza.addEdge(new Edge(ginza, tokyo, 0.9));
		tokyo.addEdge(new Edge(tokyo, ginza, 0.9));

		tokyo.addEdge(new Edge(tokyo, kasumigaseki, 1.2));
		kasumigaseki.addEdge(new Edge(kasumigaseki, tokyo, 1.2));

		otemachi.addEdge(new Edge(otemachi, tokyo, 0.7));
		tokyo.addEdge(new Edge(tokyo, otemachi, 0.7));

		hongoSanchome.addEdge(new Edge(hongoSanchome, korakuen, 1.0));
		korakuen.addEdge(new Edge(korakuen, hongoSanchome, 1.0));
		
		otemachi.addEdge(new Edge(otemachi, hongoSanchome, 1.5));
		hongoSanchome.addEdge(new Edge(hongoSanchome, otemachi, 1.5));
		
		ikebukuro.addEdge(new Edge(ikebukuro, korakuen, 1.2));
		korakuen.addEdge(new Edge(korakuen, ikebukuro, 1.2));
//1 part
		shibuya.addEdge(new Edge(shibuya, ikebukuro, 5.5));
		ikebukuro.addEdge(new Edge(ikebukuro, shibuya, 5.5));

		shibuya.addEdge(new Edge(shibuya, omoteSando, 1.1));
		omoteSando.addEdge(new Edge(omoteSando, shibuya, 1.1));

		shibuya.addEdge(new Edge(shibuya, mejiroJingumae, 1.3));
		mejiroJingumae.addEdge(new Edge(mejiroJingumae, shibuya, 1.3));

		shibuya.addEdge(new Edge(shibuya, ebisu, 1.2));
		ebisu.addEdge(new Edge(ebisu, shibuya, 1.2));

		omoteSando.addEdge(new Edge(omoteSando, aoyamaItchome, 1.4));
		aoyamaItchome.addEdge(new Edge(aoyamaItchome, omoteSando, 1.4));

		aoyamaItchome.addEdge(new Edge(aoyamaItchome, shimbashi, 3.2));
		shimbashi.addEdge(new Edge(shimbashi, aoyamaItchome, 3.2));

		shimbashi.addEdge(new Edge(shimbashi, tokyo, 1.5));
		tokyo.addEdge(new Edge(tokyo, shimbashi, 1.5));

		shimbashi.addEdge(new Edge(shimbashi, ebisu, 2.8));
		ebisu.addEdge(new Edge(ebisu, shimbashi, 2.8));

		shimbashi.addEdge(new Edge(shimbashi, ginza, 0.8));
		ginza.addEdge(new Edge(ginza, shimbashi, 0.8));

		shimbashi.addEdge(new Edge(shimbashi, mitsukoshimae, 2.1));
		mitsukoshimae.addEdge(new Edge(mitsukoshimae, shimbashi, 2.1));

		mitsukoshimae.addEdge(new Edge(mitsukoshimae, kanda, 1.2));
		kanda.addEdge(new Edge(kanda, mitsukoshimae, 1.2));

		kanda.addEdge(new Edge(kanda, suehirocho, 0.8));
		suehirocho.addEdge(new Edge(suehirocho, kanda, 0.8));

		suehirocho.addEdge(new Edge(suehirocho, uenoHirokoji, 0.5));
		uenoHirokoji.addEdge(new Edge(uenoHirokoji, suehirocho, 0.5));

		uenoHirokoji.addEdge(new Edge(uenoHirokoji, ueno, 0.7));
		ueno.addEdge(new Edge(ueno, uenoHirokoji, 0.7));

		ueno.addEdge(new Edge(ueno, nippori, 0.9));
		nippori.addEdge(new Edge(nippori, ueno, 0.9));

		ueno.addEdge(new Edge(ueno, asakusa, 1.6));
		asakusa.addEdge(new Edge(asakusa, ueno, 1.6));

		ueno.addEdge(new Edge(ueno, uenoOkachimachi, 0.5));
		uenoOkachimachi.addEdge(new Edge(uenoOkachimachi, ueno, 0.5));
//2nd part
		uenoOkachimachi.addEdge(new Edge(uenoOkachimachi, akihabara, 1.2));
		akihabara.addEdge(new Edge(akihabara, uenoOkachimachi, 1.2));
		
		uenoOkachimachi.addEdge(new Edge(uenoOkachimachi, ryogoku, 2.1));
		ryogoku.addEdge(new Edge(ryogoku, uenoOkachimachi, 2.1));
		
		ryogoku.addEdge(new Edge(ryogoku, kiyosumShirakawa, 1.5));
		kiyosumShirakawa.addEdge(new Edge(kiyosumShirakawa, ryogoku, 1.5));
		
		kiyosumShirakawa.addEdge(new Edge(kiyosumShirakawa, tsukishima, 1.3));
		tsukishima.addEdge(new Edge(tsukishima, kiyosumShirakawa, 1.3));
		
		tsukishima.addEdge(new Edge(tsukishima, tsukijishijo, 0.9));
		tsukijishijo.addEdge(new Edge(tsukijishijo, tsukishima, 0.9));
		
		tsukijishijo.addEdge(new Edge(tsukijishijo, shidome, 1.1));
		shidome.addEdge(new Edge(shidome, tsukijishijo, 1.1));
		
		shidome.addEdge(new Edge(shidome, daimon, 1.2));
		daimon.addEdge(new Edge(daimon, shidome, 1.2));
		
		daimon.addEdge(new Edge(daimon, akabanebashi, 1.0));
		akabanebashi.addEdge(new Edge(akabanebashi, daimon, 1.0));
		
		akabanebashi.addEdge(new Edge(akabanebashi, roppongi, 1.4));
		roppongi.addEdge(new Edge(roppongi, akabanebashi, 1.4));
		
		roppongi.addEdge(new Edge(roppongi, aoyamaItchome, 1.3));
		aoyamaItchome.addEdge(new Edge(aoyamaItchome, roppongi, 1.3));
		
		aoyamaItchome.addEdge(new Edge(aoyamaItchome, shinjukuNishiguchi, 2.5));
		shinjukuNishiguchi.addEdge(new Edge(shinjukuNishiguchi, aoyamaItchome, 2.5));
		
		shinjukuNishiguchi.addEdge(new Edge(shinjukuNishiguchi, tochomae, 1.0));
		tochomae.addEdge(new Edge(tochomae, shinjukuNishiguchi, 1.0));
				
		akihabara.addEdge(new Edge(akihabara, tokyo, 2.1));
		tokyo.addEdge(new Edge(tokyo, akihabara, 2.1));

		ikebukuro.addEdge(new Edge(ikebukuro, nippori, 3.2));
		nippori.addEdge(new Edge(nippori, ikebukuro, 3.2));

		tochomae.addEdge(new Edge(tochomae, higashiShinjuku, 1.5));
		higashiShinjuku.addEdge(new Edge(higashiShinjuku, tochomae, 1.5));

		shinjukuNishiguchi.addEdge(new Edge(shinjukuNishiguchi, higashiShinjuku, 1.2));
		higashiShinjuku.addEdge(new Edge(higashiShinjuku, shinjukuNishiguchi, 1.2));

		kasuga.addEdge(new Edge(kasuga, higashiShinjuku, 1.1));
		higashiShinjuku.addEdge(new Edge(higashiShinjuku, kasuga, 1.1));
		

		Graph graph = new Graph();

		graph.addNode(shinjuku);
		graph.addNode(ikebukuro);
		graph.addNode(higashiShinjuku);
		graph.addNode(mejiroJingumae);
		graph.addNode(shinjukuSanchome);
		graph.addNode(nishiShinjuku);
		graph.addNode(akasakaMitsuke);
		graph.addNode(kasumigaseki);
		graph.addNode(otemachi);
		graph.addNode(nippori);
		graph.addNode(ginza);
		graph.addNode(ueno);
		graph.addNode(hongoSanchome);
		graph.addNode(akihabara);
		graph.addNode(kanda);
		graph.addNode(tokyo);
		graph.addNode(korakuen);
		graph.addNode(shimbashi);
		graph.addNode(tochomae);
		graph.addNode(shinjukuNishiguchi);
		graph.addNode(aoyamaItchome);
		graph.addNode(roppongi);
		graph.addNode(akabanebashi);
		graph.addNode(daimon);
		graph.addNode(ebisu);
		graph.addNode(shibuya);
		graph.addNode(shidome);
		graph.addNode(tsukijishijo);
		graph.addNode(tsukishima);
		graph.addNode(kiyosumShirakawa);
		graph.addNode(ryogoku);
		graph.addNode(uenoOkachimachi);
		graph.addNode(kasuga);
		graph.addNode(omoteSando);
		graph.addNode(asakusa);
		graph.addNode(uenoHirokoji);
		graph.addNode(suehirocho);
		graph.addNode(mitsukoshimae);

		return graph;
	}

	public ArrayList<String> getMinimumPathCondensed(){
		ArrayList<String> condensedPathList = new ArrayList<String>(); 
		for(int arg2 = 0; arg2 < minimumPathCondensed.size(); arg2++) {
			condensedPathList.add(minimumPathCondensed.get(arg2).getStation());
		}
		return condensedPathList;
	}

	public ArrayList<String> getMinimumPath(){
		return minimumPath;
	}


}
