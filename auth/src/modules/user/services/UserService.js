import UserRepository from "../repositories/UserRepository.js";
import UserException from "../exceptions/UserException.js";

import * as httpStatus from "../../../config/constants/httpStatus.js";

class UserService {
  #repository = UserRepository.repository;

  async findByEmail(request) { 
    try {
      const { email } = request.params;
      
      this.validateRequestData(email);

      const user = await this.#repository.findByEmail(email);
      
      this.validateUserNotFound(user);

      return {
        status: httpStatus.SUCCESS,
        user: {
          id: user.id,
          name: user.name,
          email: user.email
        }
      };
    } catch (error) {
      return {
        status: error.status ? error.status : httpStatus.INTERNAL_SERVER_ERROR,
        message: error.message
      };
    }
  }
  
  validateRequestData(email) {
    if (!email) {
      throw new UserException(
        httpStatus.BAD_REQUEST,
        'User email was not informed'
      );
    }
  }

  validateUserNotFound(user) {
    if (!user) {
      throw new UserException(httpStatus.BAD_REQUEST, 'User was not found.');
    }
  }
}

export default { service: new UserService() };
