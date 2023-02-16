import Sequelize from "sequelize";

const sequelize = new Sequelize("auth-db", "admin", "1234", {
  host: "localhost",
  dialect: "postgres",
  quoteIdentifiers: false,
  define: {
    syncOnAssociation: true,
    timestamps: false,
    underscored: true,
    underscoredAll: true,
    freezeTableName: true
  }
});

sequelize.authenticate()
  .then(() => console.info("connection has been stablished!"))
  .catch(error => {
    console.error("Unable to connect to the database.");
    console.error(error.message);
  });

export default { connection: sequelize };
