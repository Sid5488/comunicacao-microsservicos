import UserService from "../services/UserService.js";

class UserController {
  async findByEmail(request, response) {
    const user = await UserService.service.findByEmail(request);

    return response.status(user.status).json(user);
  }
}

export default { controller: new UserController() };
