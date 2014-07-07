package com.rainmen.meteor;

import java.io.InputStream;
import java.net.URL;
import java.util.Optional;

/**
 * Contains code for communicating with websites
 *
 * @author see AUTHORS file
 * @version 1.0
 *
 */
public class NetworkAccess {

    /**
     * The caller is responsible for closing the input stream
     *
     * @param query
     *              url query
     * @return
     *          result of the query as input stream
     */
    public static Optional<InputStream> getStreamFromQuery(String query) {
        try {
            URL url = new URL(query);
            InputStream is = url.openStream();
            return Optional.of(is);
        }
        catch (Exception e) {
            System.out.println("Unable to get stream from query: " + query);
            System.out.println("Error message: " + e.getMessage());
        }

        return Optional.empty();
    }
}
