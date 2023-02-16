import model from "../model/UserModel.js";

class UserRepository {
  #model = model.UserModel;

  async findById(id) {
    try {
      return await this.#model.findOne({ where: { id } });
    } catch (error) {
      console.error(error.message);

      return null;
    }
  }

  async findByEmail(email) {
    try {
      return await this.#model.findOne({ where: { email } });
    } catch (error) {
      console.error(error.message);

      return null;
    }
  }
}

export default { repository: new UserRepository() };
