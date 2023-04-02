package beans;

public class Pret {

        private int idAdherent;
        private int idOeuvre;
        private String datePret;

        public Pret(int idAdherent, int idOeuvre, String datePret) {
            this.idAdherent = idAdherent;
            this.idOeuvre = idOeuvre;
            this.datePret = datePret;
        }

        public int getIdAdherent() {
            return idAdherent;
        }

        public int getIdOeuvre() {
            return idOeuvre;
        }

        public String getDatePret() {
            return datePret;
        }

}
