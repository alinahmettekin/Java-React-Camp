package kodlamaio.northwind.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.northwind.business.abstracts.UserService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import kodlamaio.northwind.core.utilities.results.SuccessResult;
import kodlamaio.northwind.dataAccess.abstracts.UserDao;
import kodlamaio.northwind.entities.concretes.User;

@Service
public class UserManager implements UserService {

	
	private UserDao userdao;
	
	@Autowired
	public UserManager(UserDao userdao) {
		super();
		this.userdao = userdao;
	}

	@Override
	public Result add(User user) {
		this.userdao.save(user);
		return new SuccessResult("User added");
	}

	@Override
	public DataResult<User> findByEmail(String email) {
		return new SuccessDataResult<User>("Find user",this.userdao.findByEmail(email));
	}

}
