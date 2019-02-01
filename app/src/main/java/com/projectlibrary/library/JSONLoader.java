package com.projectlibrary.library;
/**
 * @author Lyuboslav Karev
 * @version 0.1
 * @since 0.1
 */

import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.*;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class JSONLoader extends AsyncTask<String, String, String> {

    public QueryType queryType;
    public JSONLoader(){
        //set context variables if required
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    /**
     Description of this class:
     The JSONLoader class takes care for the loading of the JSON from the server.
     It sends requests to the server, and the server returns a JSON string.
     The class sends an async request to the server.

     How does this class work?
     We call it by using: new JSONLoader().execute(params);
        where params are:
        params[0] - the query type in number type (check JSONHanlder -> QueryType)
        params[1] - additional info to the query (ex. ids)

     Based on the params send to the class, we construct the JSON request that is going to be sent
     to the server. Then the request is sent to the server and the response is returned as a String

     makeServiceCall() is the main method that is used in this class.

     The class is called upon the following way:
        String res = new JSONLoader().execute(params).get();
     **/
    @Override
    protected String doInBackground(String... params) {
        try {
            return makeServiceCall(params);
        } catch (Exception e) {
            Log.d("TestCon", "Error" + e.getMessage());
        }
        return "Failed";
    }



    public String makeServiceCall(String... paramsM) {
        String reqUrl = "http://booky.lkarev.com/api/"; // URL to call
        String response = null, data = null;
        OutputStream out = null;
        JSONObject json = new JSONObject();


        /**
         * qtInt - the query type from the params string
         * After that, we get the QueryType object based on the input
         * Based on what the query is, we get the proper QueryType object and construct the JSON
         */
        int qtInt = Integer.parseInt(paramsM[0]);
        queryType = QueryType.values()[qtInt];
        if(queryType == QueryType.BookSmall || queryType == QueryType.BookFull || queryType == QueryType.BookSingle)
        {
            try {
                json.put("MC", 1);
                json.put("ID", Integer.parseInt(paramsM[1]));

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        else if(queryType == QueryType.BookNine)
        {
            try { 
                JSONArray ids = new JSONArray();
                for(int i = 0; i < 9; i++)
                {
                    ids.put(Integer.parseInt(paramsM[i + 1]));
                }
                json.put("MC", 4);
                json.put("IDS", ids);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }


        /**
         * Here we create the connection to the server
         */
        data = json.toString();
        try {
            URL url = new URL(reqUrl);
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");
            conn.setDoInput(true);
            conn.setDoOutput(true);

            params.clear();
            params.add(new BasicNameValuePair("request", data));
            out = conn.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out, "UTF-8"));

            writer.write(getQuery(params));
            writer.flush();
            writer.close();
            out.close();

            conn.connect();
            // read the response
            InputStream in = new BufferedInputStream(conn.getInputStream());
            response = convertStreamToString(in);

        } catch (MalformedURLException e) {
            Log.e("TestCon", "MalformedURLException: " + e.getMessage());
        } catch (ProtocolException e) {
            Log.e("TestCon", "ProtocolException: " + e.getMessage());
        } catch (IOException e) {
            Log.e("TestCon", "IOException: " + e.getMessage());
        } catch (Exception e) {
            Log.e("TestCon", "Exception: " + e.getMessage());
        }

        /**
         * Error handling
         * If there are no errors, we convert the JSON string to objects and pass them to the
         *  application directly
         */
        Log.d("TestCon", "Response from server: " + response);
        if(response.startsWith("{E"))
        {

        }
        else
        {
            if(queryType == QueryType.BookSmall || queryType == QueryType.BookFull || queryType == QueryType.BookSingle)
            {
                JSONHandler js = new JSONHandler(response, QueryType.BookSingle);
                bookActivity.book = js.getSingleBook();
                bookActivity.author = js.getAuthorFromSingleBook();
            }
            else if(queryType == QueryType.BookNine)
            {
                JSONHandler jsonHandler = new JSONHandler(response, QueryType.BookNine);
                LibraryActivity.books = jsonHandler.getReadingBooks();
            }
        }


        return response;
    }

    private String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return sb.toString();
    }
    private String getQuery(List<NameValuePair> params) throws UnsupportedEncodingException
    {
        StringBuilder result = new StringBuilder();
        boolean first = true;

        for (NameValuePair pair : params)
        {
            if (first)
                first = false;
            else
                result.append("&");

            result.append(URLEncoder.encode(pair.getName(), "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(pair.getValue(), "UTF-8"));
        }

        return result.toString();
    }
}


