package com.github.spring.boot.jackson.application;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * create in 2022/8/1 20:37
 *
 * @author shishaodong
 * @version 0.0.1
 */

@NoArgsConstructor
@Data
public class DemoData {

    @JsonProperty("sites")
    private SitesValue sites;

    @NoArgsConstructor
    @Data
    public static class SitesValue {
        @JsonProperty("id")
        private String id;
        @JsonProperty("name")
        private String name;
        @JsonProperty("url")
        private String url;
        @JsonProperty("lang")
        private LangDTO lang;
        @JsonProperty("address")
        private List<AddressDTO> address;

        public SitesValue(String id) {
            this.id = id;
        }

        @NoArgsConstructor
        @Data
        public static class LangDTO {
            @JsonProperty("en")
            private String en;
            @JsonProperty("zn")
            private String zn;
        }

        @NoArgsConstructor
        @Data
        public static class AddressDTO {
            @JsonProperty("city")
            private String city;
            @JsonProperty("province")
            private String province;
        }
    }
}
