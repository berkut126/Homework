package ru.randomfqdn.homework.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-02-02T15:48:14.721923900+03:00[Europe/Moscow]")

@Controller
@RequestMapping("${openapi..base-path:}")
public class LessonsApiController implements LessonsApi {

    private final NativeWebRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public LessonsApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

}
