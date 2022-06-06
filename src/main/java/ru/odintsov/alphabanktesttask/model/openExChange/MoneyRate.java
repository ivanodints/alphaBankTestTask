package ru.odintsov.alphabanktesttask.model.openExChange;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Map;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class MoneyRate implements Serializable{

    private int timestamp;
    private String base;
    private String disclaimer;
    private String license;
    private Map<String, Double> rates;
}
