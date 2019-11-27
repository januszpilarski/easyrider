package com.jpl.easyrider.Services;

import com.jpl.easyrider.InterfaceServices.DBFileService;
import com.jpl.easyrider.domain.DBFile;
import com.jpl.easyrider.domain.User;
import com.jpl.easyrider.repositories.DBFileRepository;
import com.jpl.easyrider.web.error.FileStorageException;
import com.jpl.easyrider.web.error.MyFileNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class DBFileStorageService implements DBFileService {

    @Autowired
    private DBFileRepository dbFileRepository;

    public DBFile storeFile(MultipartFile file) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            DBFile dbFile = new DBFile(fileName, file.getContentType(), file.getBytes());

            return dbFileRepository.save(dbFile);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    @Override
    public DBFile findDBFileByID(long id) {
        return dbFileRepository.findById(id)
                .orElseThrow(() -> new MyFileNotFoundException("File not found with id " + id));
    }

    @Override
    public List<DBFile> findAll() {
        return dbFileRepository.findAll();
    }
}
