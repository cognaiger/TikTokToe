public class Cell {
    private CellStatus status;

    public Cell() {
        this.status = CellStatus.EMPTY;
    }

    public CellStatus getStatus() {
        return status;
    }

    public void setStatus(CellStatus status) {
        this.status = status;
    }
}
