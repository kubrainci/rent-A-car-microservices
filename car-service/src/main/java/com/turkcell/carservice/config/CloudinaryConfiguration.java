package com.turkcell.carservice.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudinaryConfiguration {


    private final String cloudName= "dfeqza4k5";
    private final String  apiKey= "391921922588816";
    private final String apiSecret= "SgS754XI9gWoctBfiv3bMLQQC8c";


    @Bean
    public Cloudinary cloudinary(){
        return new Cloudinary(
              ObjectUtils.asMap(
                "cloud_name", cloudName,
                "api_key", apiKey,
                "api_secret", apiSecret));
    }

}
