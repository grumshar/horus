package pl.dcielicki;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class MyStructureTest {

    private static MyStructure myStructure;
    private static ICompositeNodeImpl compositeNode;

    private static final INodeImpl NODE_ONE = new INodeImpl("code1", "renderer1");
    private static final INodeImpl NODE_TWO = new INodeImpl("code2", "renderer2");
    private static final INodeImpl NODE_THREE = new INodeImpl("code3", "renderer3");
    private static final INodeImpl NODE_FOUR = new INodeImpl("code4", "renderer4");
    private static final INodeImpl NODE_FIVE = new INodeImpl("code5", "renderer5");
    private static final INodeImpl NODE_SIX = new INodeImpl("code6", "renderer6");
    private static final ICompositeNodeImpl COMPOSITE_NODE_ONE =
            new ICompositeNodeImpl("codeComposite1", "rendererComposite1");
    private static final ICompositeNodeImpl COMPOSITE_NODE_TWO =
            new ICompositeNodeImpl("codeComposite2", "rendererComposite2");
    private static final ICompositeNodeImpl COMPOSITE_NODE_THREE =
            new ICompositeNodeImpl("codeComposite3", "rendererComposite3");

    @BeforeAll
    public static void initilizeNodes() {
        myStructure = new MyStructure();
        myStructure.addNode(NODE_ONE);
        myStructure.addNode(NODE_TWO);
        myStructure.addNode(COMPOSITE_NODE_ONE);
        COMPOSITE_NODE_ONE.addNode(NODE_THREE);
        COMPOSITE_NODE_ONE.addNode(COMPOSITE_NODE_TWO);
        COMPOSITE_NODE_ONE.addNode(NODE_FOUR);
        COMPOSITE_NODE_TWO.addNode(COMPOSITE_NODE_THREE);
        COMPOSITE_NODE_THREE.addNode(NODE_FIVE);
        COMPOSITE_NODE_THREE.addNode(NODE_SIX);
    }


    @Test
    void testFindByCode_NodeFound() {
        assertEquals(NODE_SIX, myStructure.findByCode("code6"));
        assertEquals(NODE_TWO, myStructure.findByCode("code2"));
        assertEquals(COMPOSITE_NODE_THREE, myStructure.findByCode("codeComposite3"));
    }

    @Test
    void testFindByCode_NodeNotFound() {
        assertNull(myStructure.findByCode("wrongCode"));
    }

    @Test
    void testFindByRenderer_NodeFound() {
        assertEquals(NODE_FIVE, myStructure.findByRenderer("renderer5"));
        assertEquals(COMPOSITE_NODE_TWO, myStructure.findByRenderer("rendererComposite2"));
    }

    @Test
    void testFindByRenderer_NodeNotFound() {
        assertNull(myStructure.findByRenderer("wrongRenderer"));
    }

    @Test
    void testCount() {
        assertEquals(9, myStructure.count());
    }

}