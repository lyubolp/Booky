package com.projectlibrary.library;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

//import org.apache.commons.io.IOUtils;
/*import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
//import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;*/

public final class ConnectionManager {
    /*private ConnectionManager() {} // Disallow initialization of objects of this class

    private static boolean initialized = false;
    private static HttpClient httpClient = HttpClients.createDefault(); // Used to execute requests to the httpPost
    private static HttpPost httpPost = new HttpPost(""); // The link of the api
    private static ArrayList<BasicNameValuePair> parameters = new ArrayList<BasicNameValuePair>(1); // Contains the { "request" : "..." }

    // The host is set when this object is initiated
    static void Initialize(String ServerUrl) {
        httpPost = new HttpPost(ServerUrl);
        initialized = true;
    }



    // Shortcut so you don't have to type Json.toString() as an argument every time
    public static String SendMessage(JsonObject Json) {
        return SendMessage(Json.toString());
    }

    public static String SendMessage(String JsonRequestString) {
        if (!initialized) {
            return "ConnectionManager has not been initialized. Please use ConnectionManager.Initialize(url-to-server); first";
        }

        // Set the message parameters
        parameters.clear();
        parameters.add(new BasicNameValuePair("request", JsonRequestString));

        // Needed for the Bulgarian translation of objects
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(parameters, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            return "Failed to encode the message in UTF-8.";
        }


        // Send the message
        HttpResponse response;
        try {
            response = httpClient.execute(httpPost);
        } catch (IOException e) {
            return "Failed to execute the POST request.";
        }
        HttpEntity responseEntity = response.getEntity();

        if (responseEntity != null) {
            InputStream instream = null;
            try {
                instream = responseEntity.getContent();
            } catch (UnsupportedOperationException | IOException e) {
                return "Failed to read the message";
            }

            try {
                String returnedMessage = IOUtils.toString(instream, "UTF-8");
                instream.close();
                return returnedMessage;
            } catch (IOException e) {
                try {
                    instream.close();
                } catch (IOException e1) {
                    return "Failed to close the Input Stream";
                }
                return "Failed to encode the response in UTF-8";
            }
        }
        return "The response was empty.";
    }*/
}
