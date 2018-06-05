import java.security.Principal;
import java.util.Objects;

/**
 * @author wangjinyang@g7.com.cn
 */
public class ExamplePrincipal implements Principal {

    private final String name;

    public ExamplePrincipal(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Null name");
        }
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "ExamplePrincipal：" + name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ExamplePrincipal that = (ExamplePrincipal) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
