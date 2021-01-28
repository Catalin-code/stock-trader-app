package com.codecool.stockTrader;

import org.json.JSONObject;

import java.io.IOException;


public class StockAPIService {

	private final RemoteURLReader remoteURLReader;

	public StockAPIService(RemoteURLReader remoteURLReader){
		this.remoteURLReader = remoteURLReader;
	}

	public double getPrice(String symbol) throws IOException {
		String API_PATH = "https://run.mocky.io/v3/9e14e086-84c2-4f98-9e36-54928830c980?stock=%s";
		String url = String.format(API_PATH, symbol);
		String result = remoteURLReader.readFromUrl(url);
		JSONObject json = new JSONObject(result);
        String price = json.get("price").toString();
        return Double.parseDouble(price);
	}
	
	public boolean buy(String symbol) {
		// Stub. No need to implement this.
		return true;
	}
}
