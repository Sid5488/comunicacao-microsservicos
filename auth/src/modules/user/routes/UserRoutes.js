import { Router } from 'express';

import UserController from '../controllers/UserController.js';

const { controller } = UserController;

const router = new Router();

router.get('/api/user/email/:email', controller.findByEmail);

export default { router };
