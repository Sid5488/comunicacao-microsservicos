import { compare } from 'bcrypt';
import jwt from 'jsonwebtoken';

import UserRepository from "../repositories/UserRepository.js";
import UserException from "../exceptions/UserException.js";

import authConfig from '../../../config/constants/secrets.js';
import * as httpStatus from "../../../config/constants/httpStatus.js";

class UserService {
  #repository = UserRepository.repository;

  async findByEmail(request) { 
    try {
      const { email } = request.params;
      const { authUser } = request;
      
      this.validateRequestData(email);

      const user = await this.#repository.findByEmail(email);
      
      this.validateUserNotFound(user);
      this.validateAuthenticatedUser(user, authUser);

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

  async getAccessToken(request) {
    try {
      const { email, password } = request.body;
  
      this.validateAccessTokenData(email, password);

      const user = await this.#repository.findByEmail(email);

      this.validateUserNotFound(user);
      this.validatePassword(password, user.password);

      const authUser = {
        id: user.id,
        name: user.name,
        email: user.email
      };

      const accessToken = jwt.sign({ authUser }, authConfig.secret, {
        expiresIn: '1d'
      });

      return {
        status: httpStatus.SUCCESS,
        accessToken,
      };
    } catch (error) {
      console.error(error.message);

      return {
        status: error.status ? error.status : httpStatus.INTERNAL_SERVER_ERROR,
        message: error.message
      };
    }
  }

  validateAccessTokenData(email, password) {
    if (!email || !password) {
      throw new UserException(
        httpStatus.UNAUTHORIZED,
        "Email and password must be informed"
      );
    }
  }

  validateAuthenticatedUser(user, authUser) {
    if (!authUser || user.id !== authUser.id) {
      throw new UserException(
        httpStatus.FORBIDDEN,
        "You cannot see this user data!"
      );
    }
  }

  async validatePassword(password, hashPassword) {
    if (!await compare(password, hashPassword)) {
      throw new UserException(
        httpStatus.UNAUTHORIZED,
        "Email or password incorrect!"
      );
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
