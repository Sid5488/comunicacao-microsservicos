import jwt from 'jsonwebtoken';
import { promisify } from 'util';

import * as httpStatus from "../../config/constants/httpStatus.js";
import authConfig from '../../config/constants/secrets.js';

import AuthException from './AuthException.js';

const prefixSpace = ' ';

const tokenValidation = (accessToken) => {
  if (accessToken.includes(prefixSpace)) {
    const [, token] = accessToken.split(prefixSpace);

    return token;
  }

  return accessToken;
};

const checkToken = async (request, response, next) => {
  try {
    const { authorization } = request.headers;
  
    if (!authorization) {
      throw new AuthException(
        httpStatus.UNAUTHORIZED,
        "Access token not informed"
      );
    }

    const accessToken = tokenValidation(authorization);
    const decoded = await promisify(jwt.verify)(accessToken, authConfig.secret);

    request.authUser = decoded.authUser;

    return next();
  } catch (error) {
    const status = error.status
      ? error.status
      : httpStatus.INTERNAL_SERVER_ERROR;

    return response.status(status).json({ status, message: error.message });
  }
  
  next();
};

export { checkToken };
