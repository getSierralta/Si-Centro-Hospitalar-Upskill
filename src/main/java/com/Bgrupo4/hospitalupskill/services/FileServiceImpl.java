package com.Bgrupo4.hospitalupskill.services;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.*;

@Service
public class FileServiceImpl implements  FileService{

    File folder = new File("src/main/resources/static/files");
    List<File> files = Arrays.asList(Objects.requireNonNull(folder.listFiles()));

    @Override
    public List<String> getFiles() {
        List<String> fileNames = new ArrayList<>();
        for(File file: files){
            fileNames.add("../files/" + file.getName());
        }
        return fileNames;
    }

    @Override
    public List<String> getFiles(String name) {
        List<String> filesByName = new ArrayList<>();
        for(File file: files){
            if(file.getName().equals(name)){
                filesByName.add(file.getPath());
            }
        }
        return filesByName;
    }

    @Override
    public List<String> getFiles(Date date) {
        List<String> filesByDate = new ArrayList<>();
        for(File file: files){
            if(file.lastModified() == date.getTime()){
                filesByDate.add(file.getPath());
            }
        }
        return filesByDate;
    }


}
