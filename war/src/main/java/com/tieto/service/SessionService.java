package com.tieto.service;

import lombok.Getter;
import lombok.Setter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
@Getter
@Setter
public class SessionService {

    private String name;

}
