package pl.dcielicki;

public class INodeImpl implements INode {

    private String code;
    private String renderer;

    public INodeImpl(String code, String renderer) {
        this.code = code;
        this.renderer = renderer;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getRenderer() {
        return this.renderer;
    }

    @Override
    public String toString() {
        return "INodeImpl{" +
                "code='" + code + '\'' +
                ", renderer='" + renderer + '\'' +
                '}';
    }
}
