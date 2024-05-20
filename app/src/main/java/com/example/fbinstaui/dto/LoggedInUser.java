package com.example.fbinstaui.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class LoggedInUser {
    private String email;
    private String password;

}
