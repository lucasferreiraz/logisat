package abstractions.operators;

import abstractions.formulas.Formula;

public class Not extends Formula {

    private Formula inner;

    public Not(Formula inner) {
        this.inner = inner;
    }

    @Override
    public String toString() {
        return "(" + "~" + inner + ")";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((inner == null) ? 0 : inner.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Not other = (Not) obj;
        if (inner == null) {
            if (other.inner != null)
                return false;
        } else if (!inner.equals(other.inner))
            return false;
        return true;
    }
    
}
