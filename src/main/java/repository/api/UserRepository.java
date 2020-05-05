package repository.api;

import model.entity.User;

public interface UserRepository extends Crud<User> {

    User loadByUserName(String userName);

}
