package br.univille.microkernel_plugin.service;


import br.univille.microkernel_interface.service.DefaultService;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ServiceTwoImpl implements DefaultService {

    @Override
    public HttpStatus doWork(HashMap<String, String> params) {
        System.out.println("Service TWO " + params);
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }

}
