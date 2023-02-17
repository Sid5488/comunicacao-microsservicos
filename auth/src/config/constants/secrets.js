const env = process.env;

export default {
  secret: env.API_SECRET ? env.API_SECRET : 'YXV0aC1hcGktZGV2LXdveg=='
};
