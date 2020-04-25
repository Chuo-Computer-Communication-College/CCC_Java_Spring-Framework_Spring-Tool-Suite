package com.example.app;

import java.io.InputStream;
import java.util.Scanner;

import org.springframework.stereotype.Component;

@Component
public class ScannerArgumentResolver implements ArgumentResolver
{
    @Override
    public Argument resolve(InputStream is)
    {
        Scanner scnr = new Scanner(is);

        int intA = scnr.nextInt();
        int intB = scnr.nextInt();
        
        return new Argument(intA, intB);
    }
}
