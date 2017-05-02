/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.utilities;

import java.util.HashMap;

/**
 *
 * @author pullis
 */
public class Fields {
    
	static HashMap<String, String[]> required = new HashMap<>();
	static HashMap<String, String[]> optional = new HashMap<>();

	public Fields() {
		initRequired();
		initOptional();
	}

	public static String[] getRequired(String key) {
		return required.get(key.toLowerCase());
	}

	public static String[] getOptional(String key) {
		return optional.get(key.toLowerCase());
	}

	public static String[] getAll(String key) {
		String keyLowercase = key.toLowerCase();
		String[] ret = new String[required.get(keyLowercase).length + optional.get(keyLowercase).length];
		int helper = 0;
		for (int i = 0; i < required.get(keyLowercase).length; i++) {
			ret[helper] = required.get(keyLowercase)[i];
			helper++;
		}
		for (int i = 0; i < optional.get(keyLowercase).length; i++) {
			ret[helper] = optional.get(keyLowercase)[i];
			helper++;
		}
		return ret;
	}
    
    private void initRequired() {
        required.put("article",         new String[]{"author", "title", "journal", "year", "volume"});
        required.put("book",            new String[]{"author", "title", "publisher", "year"});
        required.put("booklet",         new String[]{"title"});
        required.put("conference",      new String[]{"author", "title", "booktitle", "year"});
        required.put("inbook",          new String[]{"author", "title", "pages", "publisher", "year"});
        required.put("incollection",    new String[]{"author", "title", "booktitle", "publisher", "year"});
        initReqHelper();
        
    }
    
    private void initReqHelper() {
        required.put("inproceedings",   new String[]{"author", "title", "booktitle", "year"});
        required.put("manual",          new String[]{"title"});
        required.put("mastersthesis",   new String[]{"author", "title", "school", "year"});
        required.put("misc",            new String[]{});
        required.put("phdthesis",       new String[]{"author", "title", "school", "year"});
        required.put("proceedings",     new String[]{"title", "year"});
        required.put("techreport",      new String[]{"author", "title", "institution", "year"});
        required.put("unpublished",     new String[]{"author", "title", "note"});
    }
    
    private void initOptional() {
        optional.put("article",         new String[]{"number", "pages", "month", "note", "key"});
        optional.put("book",            new String[]{"number", "series", "address", "edition", "month", "note", "key"});
        optional.put("booklet",         new String[]{"author", "howpublished", "address", "month", "year", "note", "key"});
        optional.put("conference",      new String[]{"editor", "volume", "series", "pages", "address", "month", "organization", "publisher", "note", "key"});
        optional.put("inbook",          new String[]{"volume", "series", "type", "address", "edition", "month", "note", "key"});
        optional.put("incollection",    new String[]{"editor", "volume", "series", "type", "chapter", "pages", "address", "edition", "month", "note", "key"});
        initOptHelper();
    }
    
    private void initOptHelper() {
        optional.put("inproceedings",   new String[]{"editor", "volume", "series", "pages", "address", "month", "organization", "publisher", "note", "key"});
        optional.put("manual",          new String[]{"author", "organization", "address", "edition", "month", "year", "note", "key"});
        optional.put("mastersthesis",   new String[]{"type", "address", "month", "note", "key"});
        optional.put("misc",            new String[]{"author", "title", "howpublished", "month", "year", "note", "key"});
        optional.put("phdthesis",       new String[]{"type", "address", "month", "note", "key"});
        optional.put("proceedings",     new String[]{"editor", "volume", "series", "address", "month", "publisher", "organization", "note", "key"});
        optional.put("techreport",      new String[]{"type", "number", "address", "month", "note", "key"});
        optional.put("unpublished",     new String[]{"month", "year", "key"});
    }
}

