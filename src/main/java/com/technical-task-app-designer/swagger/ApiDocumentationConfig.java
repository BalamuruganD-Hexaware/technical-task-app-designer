package com.technical-task-app-designer.swagger;

import io.swagger.annotations.Contact;
import io.swagger.annotations.ExternalDocs;
import io.swagger.annotations.Info;
import io.swagger.annotations.License;
import io.swagger.annotations.SwaggerDefinition;

@SwaggerDefinition(
        info = @Info(
                description = "Technical-task-app-designer Resources",
                version = "V12.0.12",
                title = "Technical-task-app-designer Resource API",
                contact = @Contact(
                   name = "Technical-task-app-designer Team", 
                   email = "technical-task-app-designer@hexaware.com", 
                   url = "http://www.hexaware.com"
                ),
                license = @License(
                   name = "Technical-task-app-designer 2.0", 
                   url = "http://www.hexaware.com/licenses/LICENSE-2.0"
                )
        ),
        consumes = {"application/json", "application/xml"},
        produces = {"application/json", "application/xml"},
        schemes = {SwaggerDefinition.Scheme.HTTP, SwaggerDefinition.Scheme.HTTPS},
        externalDocs = @ExternalDocs(value = "Read This For Sure", url = "http://www.technical-task-app-designer.org")
)
public interface ApiDocumentationConfig {

}