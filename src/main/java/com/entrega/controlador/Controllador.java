package com.entrega.controlador;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.entrega.modelo.Buscador;
import com.entrega.modelo.BuscadorNombre;
import com.entrega.modelo.Detalles;
import com.entrega.modelo.Location;
import com.entrega.modelo.Pokemon;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class Controllador {
	private String url = "https://pokeapi.co/api/v2/location";
//	@Autowired
//	private RestTemplate client;

	@RequestMapping(value = "/generacion", params = "id")
	public String generaciones(@RequestParam String id, Model model) {
		Integer num = 0;
		Boolean pas = false;
		switch (id) {
		case "1":
			num = 1;
			pas = true;
			break;
		case "2":
			num = 152;
			pas = true;
			break;
		case "3":
			num = 252;
			pas = true;
			break;
		case "4":
			num = 387;
			pas = true;
			break;
		case "5":
			num = 494;
			pas = true;
			break;
		case "6":
			num = 650;
			pas = true;
			break;
		}
		if (!pas) {
			id = "1";
			num = 1;
		}
		RestTemplate client = new RestTemplate();
		HttpHeaders h = new HttpHeaders();
		h.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
//		if(id == null) {id = "1";}
		String tUrl = "https://pokeapi.co/api/v2/generation/" + id;
		ResponseEntity<String> res = client.exchange(tUrl, HttpMethod.GET, null, String.class);
		JSONObject jsonObj = new JSONObject(res.getBody().toString());
		JSONArray result = jsonObj.getJSONArray("pokemon_species");
		ArrayList<Pokemon> listdata = new ArrayList<Pokemon>();
		if (result != null) {
			for (int i = 0; i < result.length(); i++) {
				Pokemon t = new Pokemon();
				JSONObject tt = new JSONObject(result.get(i).toString());
				t.setName(tt.getString("name"));
				t.setUrl(tt.getString("url"));
				listdata.add(t);
			}
		}
		model.addAttribute("pokemones", listdata);
		model.addAttribute("num", num);
		model.addAttribute("name", jsonObj.getString("name"));
		return "generaciones";
	}

	@RequestMapping(value = "/buscador", method = RequestMethod.POST)
	public String buscador(@ModelAttribute("buscador") Buscador p, Model model) {
		Integer num = 1;
		ArrayList<Pokemon> listdata = new ArrayList<Pokemon>();
		if (p.getA() < p.getB()) {
			RestTemplate client = new RestTemplate();
			HttpHeaders h = new HttpHeaders();
			h.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
			// if(id == null) {id = "1";}
			String tUrl = "https://pokeapi.co/api/v2/pokemon-species/?limit=" + p.getA().toString() + "&offset="
					+ p.getB().toString();
			ResponseEntity<String> res = client.exchange(tUrl, HttpMethod.GET, null, String.class);
			JSONObject jsonObj = new JSONObject(res.getBody().toString());
			JSONArray result = jsonObj.getJSONArray("results");
			if (result != null) {
				for (int i = 0; i < result.length(); i++) {
					Pokemon t = new Pokemon();
					JSONObject tt = new JSONObject(result.get(i).toString());
					t.setName(tt.getString("name"));
					t.setUrl(tt.getString("url"));
					listdata.add(t);
				}
			}
		}
		model.addAttribute("pokemones", listdata);
		model.addAttribute("num", num);
		model.addAttribute("name", "Buscando por rango");
		return "generaciones";
	}

	@RequestMapping(value = "/buscadorNombre", method = RequestMethod.POST)
	public String buscadorNombre(@ModelAttribute("buscadorNombre") BuscadorNombre p, Model model) {
		Integer num = 1;
		ArrayList<Detalles> listdata = new ArrayList<Detalles>();
		RestTemplate client = new RestTemplate();
		HttpHeaders h = new HttpHeaders();
		h.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
//		if(id == null) {id = "1";}
		String tUrl = "https://pokeapi.co/api/v2/pokemon-species/" + p.getDato();
		ResponseEntity<String> res = client.exchange(tUrl, HttpMethod.GET, null, String.class);
		JSONObject jsonObj = new JSONObject(res.getBody().toString());
		Detalles pokemon = new Detalles();
		JSONObject colores = jsonObj.getJSONObject("color");
		pokemon.setColor(colores.getString("name"));
		JSONArray genera = jsonObj.getJSONArray("genera");
		if (genera != null) {
			for (int i = 0; i < genera.length(); i++) {
				JSONObject tt = new JSONObject(genera.get(i).toString());
				JSONObject idio = new JSONObject(tt.get("language").toString());
				if (idio.get("name").toString().equals("es")) {
					pokemon.setTipo(tt.getString("genus"));
				}
			}
		}
		JSONArray names = jsonObj.getJSONArray("names");
		if (names != null) {
			for (int i = 0; i < names.length(); i++) {
				JSONObject tt = new JSONObject(names.get(i).toString());
				JSONObject idio = new JSONObject(tt.get("language").toString());
				if (idio.get("name").toString().equals("es")) {
					pokemon.setName(tt.get("name").toString());
				}
			}
		}
		model.addAttribute("pokemon", pokemon);
		model.addAttribute("name", "Buscando por Nombre");
		return "pokemon";
	}

	@GetMapping("/buscarNombre")
	public String buscarNombreGet(Model model) {
		BuscadorNombre bus = new BuscadorNombre();
		model.addAttribute("buscadorNombre", bus);
		return "buscarNombre";
	}

	@GetMapping("/pruebas")
	public String pruebas(Model model) {
		RestTemplate client = new RestTemplate();
		HttpHeaders h = new HttpHeaders();
		h.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		ResponseEntity<String> res = client.exchange("https://pokeapi.co/api/v2/generation/1", HttpMethod.GET, null,
				String.class);
		model.addAttribute("res", res.getBody().toString());
//		return res.getBody();
		return "pruebas";
	}

	@GetMapping("/buscar")
	public String buscarGet(Model model) {
		Buscador bus = new Buscador();
		model.addAttribute("buscador", bus);
		return "buscar";
	}
}
