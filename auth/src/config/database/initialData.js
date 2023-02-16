import { hash } from "bcrypt";

import model from "../../modules/user/model/UserModel.js";

const userModel = model.UserModel;

async function createInitialData() {
  try {
    await userModel.sync({ force: true });

    const password = await hash('123456', 10);
  
    await userModel.create({
      name: 'User Test',
      email: 'test@test.com',
      password: ""
    }); 
  } catch (error) {
    console.error(error);
  }
};

export { createInitialData };
