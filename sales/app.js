import express from "express";

const app = express();
const env = process.env;
const PORT = env.PORT || 8083;

app.get("/api/health-check", (request, response) => {
  return response.status(200).json({
    status: 'online',
    service: 'Sales-API',
    httpStatus: 200
  });
});

app.listen(PORT,
  () => console.info(`Server started successfully at port ${PORT}`)
);
