package com.jpl.easyrider.InterfaceServices;

import com.jpl.easyrider.domain.DBFile;

import java.util.List;

public interface DBFileService {

    DBFile findDBFileByID(long id);

    List<DBFile> findAll();
}
