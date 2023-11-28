package service;

import dao.Userdao;
import dto.Userdto;
import helper.AES;

public class UserService {
	public boolean saveUser(Userdto dto)
	{
		if(dto.getAge()<18)
		{
			return false;
		}
		else
		{
			Userdao dao=new Userdao();
			Userdto dto1=dao.findByEmail(dto.getEmail());
			if(dto1 !=null)
			{
				return false;
			}
			else
			{
				dto.setPassword(AES.encrypt(dto.getPassword(), "123"));
				dao.saveUser(dto);
				return true;
			}
			
		}
	}
	public boolean login(String email,String password)
	{
		Userdao dao=new Userdao();
		Userdto dto=dao.findByEmail(email);
		if(dto==null)
		{
			return false;
		}
		else
		{
			
			if(password.equals(AES.decrypt(dto.getPassword(), "123")))
				return true;
			else
				return false;
			
		}
	}

}
