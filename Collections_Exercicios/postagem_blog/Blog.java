import java.util.*;
import java.util.stream.Collectors;

public class Blog {
    private Set<Post> postagens = new HashSet<>();

    public void adicionarPostagem(Post post) {
        for (Post p : postagens) {
            if (p.getAutor().equals(post.getAutor()) && p.getTitulo().equals(post.getTitulo())) {
                throw new RuntimeException("Postagem jah existente");
            }
        }
        postagens.add(post);
    }

    public Set<Autor> obterTodosAutores() {
        return postagens.stream()
            .sorted(Comparator.comparing(Post::getTitulo))
            .map(Post::getAutor)
            .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    public Map<Categorias, Integer> obterContagemPorCategoria() {
        Map<Categorias, Integer> contagem = new HashMap<Categorias, Integer>();
        postagens.stream()
            .sorted(Comparator.comparing(Post::getTitulo))
            .forEach(p -> contagem.put(p.getCategoria(), contagem.getOrDefault(p.getCategoria(), 0) + 1));      
        return contagem;
    }

    public Set<Post> obterPostsPorAutor(Autor autor) {
        return postagens.stream()
                .filter(p -> p.getAutor().compareTo(autor) == 0)
                .sorted(Comparator.comparing(Post::getTitulo))
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    public Set<Post> obterPostsPorCategoria(Categorias categoria) {
        return postagens.stream()
            .filter(p -> p.getCategoria().compareTo(categoria) == 0)
            .sorted(Comparator.comparing(Post::getTitulo))
            .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    public Map<Categorias, Set<Post>> obterTodosPostsPorCategorias() {
        Map<Categorias, Set<Post>> map = new HashMap<>();
        for (Categorias categoria : Arrays.asList(Categorias.values())) {
            Set<Post> posts = obterPostsPorCategoria(categoria);
            if (!posts.isEmpty()) {
                map.put(categoria, posts);
            }
        }
        return map;
    }

    public Map<Autor, Set<Post>> obterTodosPostsPorAutor() {
        Map<Autor, Set<Post>> map = new LinkedHashMap<>();
        for (Autor autor : obterTodosAutores()) {
            Set<Post> posts = obterPostsPorAutor(autor);
            if (!posts.isEmpty()) {
                map.put(autor, posts);
            }
        }
        return map;
    }
}
