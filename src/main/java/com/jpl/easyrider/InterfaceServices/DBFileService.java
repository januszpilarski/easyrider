package com.jpl.easyrider.InterfaceServices;

import com.jpl.easyrider.domain.DBFile;
import com.jpl.easyrider.domain.User;

import java.util.Optional;

public interface DBFileService {

    DBFile findDBFileByID(long id);

}
