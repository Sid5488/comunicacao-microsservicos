import { Router } from 'express';

import { checkToken } from '../../../middleware/auth/checkTokenMiddleware.js';
import UserController from '../controllers/UserController.js';

const { controller } = UserController;

const router = new Router();

router.post('/api/user/auth', controller.getAccessToken);

router.use('/api/user', checkToken);

router.get('/api/user/email/:email', controller.findByEmail);

export default { router };
