package com.waheed.cloud.configclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Value;

/**
 * Read multiple properties and yml files via Config Server
 */
@RefreshScope
@Controller
public class TestController {

    @Autowired
    private Environment environment;

    // Read properties from error-<profile>.properties
    @Autowired
    private ErrorResponse errorResponse;

    @Autowired
    private DatabaseConnection databaseConnection;

    // Read messages from application-<profile>.properties file
    @Value("${msg:Config Server is not working. Please check...}")
    private String msg;

    @ResponseBody
    @GetMapping(value = "/display",produces = MediaType.TEXT_HTML_VALUE)
    public String displayAllFilesAsHTML() {
        String response =  "<html>\n" + "<header><title>Welcome</title></header>\n" +
                "<body>\n"
                + "Active Profile: " + this.environment.getActiveProfiles()[0]
                + "<BR> Message from Properties file: " + this.msg
                + "<BR> Error Response file: " + this.errorResponse
                + "<BR> Database YAML files: " + this.databaseConnection
                + "\n</body>\n" + "</html>";

        return  response;
    }
}
