import express from "express";

import userRouter from './modules/user/routes/UserRoutes.js';

// import { createInitialData } from "./config/database/initialData.js";

const app = express();
const env = process.env;
const PORT = env.PORT || 8081;

// createInitialData();

app.use(express.json());
app.use(userRouter.router);

app.get('/api/health-check', (request, response) => {
  return response.status(200).json({
    service: 'Auth-api',
    status: 'online',
    httpStatus: 200
  });
});

app.listen(PORT, () =>
  console.info(`Server started successfully at port ${PORT}`)
);
