import UserService from "../services/UserService.js";

class UserController {
  async getAccessToken(request, response) {
    const accessToken = await UserService.service.getAccessToken(request);

    return response.status(accessToken.status).json(accessToken);
  }

  async findByEmail(request, response) {
    const user = await UserService.service.findByEmail(request);

    return response.status(user.status).json(user);
  }
}

export default { controller: new UserController() };
