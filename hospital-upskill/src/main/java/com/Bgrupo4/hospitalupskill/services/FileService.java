package com.Bgrupo4.hospitalupskill.services;
import java.util.Date;
import java.util.List;

public interface FileService {

    List<String> getFiles();

    List<String> getFiles(String name);

    List<String> getFiles(Date date);
}
