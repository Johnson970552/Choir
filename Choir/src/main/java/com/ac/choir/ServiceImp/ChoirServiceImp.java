package com.ac.choir.ServiceImp;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ac.choir.Entity.ChoirEntity;
import com.ac.choir.Repository.ChoirRepository;
import com.ac.choir.Service.ChoirService;
@Service
public class ChoirServiceImp implements ChoirService {
	@Autowired
	private ChoirRepository repository;

		@Override
		public List<ChoirEntity> getAll() {
			// TODO Auto-generated method stub
			return repository.findAll();
		}

		@Override
		public ChoirEntity getDataById(long id) {
			Optional<ChoirEntity> findById=repository.findById(id);
			return findById.get();
		
		}


		@Override
		public String DeleteData(long id) {
			repository.deleteById(id);
			return "Deleted";
		}

		@Override
		public ChoirEntity UpdateData(long id, ChoirEntity Update) {
			ChoirEntity entity=repository.findById(id).get();
			entity.setName(Update.getName());
			entity.setRole(Update.getRole());
			entity.setId(Update.getMobile());
			entity.setEmailId(Update.getEmailId());
			entity.setAdress(Update.getAdress());
			entity.setImage(Update.getImage());
			return  repository.save(null);

	}

		@Override
		public ChoirEntity saveChoir(ChoirEntity choirEntity, MultipartFile image) throws IOException {
			if(image!=null&& !image.isEmpty()) {
				 choirEntity.setImage(image.getBytes());
			}return repository.save(choirEntity);
		}

//		@Override
//		public ChoirEntity SaveData(ChoirEntity Entity) {
//			return repository.save(Entity);
//		}
//
//		

		

		

	

		



		}