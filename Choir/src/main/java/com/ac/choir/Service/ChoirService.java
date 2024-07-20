package com.ac.choir.Service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ac.choir.Entity.ChoirEntity;

public interface ChoirService {
//	public ChoirEntity SaveData(ChoirEntity Entity);
	public ChoirEntity UpdateData(long id, ChoirEntity Update);
	public ChoirEntity getDataById(long id);
	public List<ChoirEntity> getAll();
	public String DeleteData(long id);
public 	ChoirEntity saveChoir(ChoirEntity choirEntity, MultipartFile imaFile) throws IOException;

}
