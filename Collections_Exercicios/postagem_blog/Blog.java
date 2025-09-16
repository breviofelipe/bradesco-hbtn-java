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
                .map(Post::getAutor)
                .collect(Collectors.toCollection(TreeSet::new));
    }

    public Map<Categorias, Integer> obterContagemPorCategoria() {
        Map<Categorias, Integer> contagem = new HashMap<>();
        for (Post p : postagens) {
            contagem.put(p.getCategoria(), contagem.getOrDefault(p.getCategoria(), 0) + 1);
        }
        return contagem;
    }

    public Set<Post> obterPostsPorAutor(Autor autor) {
        return postagens.stream()
                .filter(p -> p.getAutor().compareTo(autor) == 0)
                .sorted() // Usa o compareTo de Post
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    public Set<Post> obterPostsPorCategoria(Categorias categoria) {
        return postagens.stream()
            .filter(p -> p.getCategoria().equals(categoria))
            .sorted() // Usa o compareTo de Post
            .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    public Map<Categorias, Set<Post>> obterTodosPostsPorCategorias() {
        Map<Categorias, Set<Post>> map = new HashMap<>();
        for (Post p : postagens) {
            map.computeIfAbsent(p.getCategoria(), k -> new TreeSet<>()).add(p);
        }
        return map;
    }

    public Map<Autor, Set<Post>> obterTodosPostsPorAutor() {
        Map<Autor, Set<Post>> map = new HashMap<>();
        for (Post p : postagens) {
            map.computeIfAbsent(p.getAutor(), k -> new TreeSet<>()).add(p);
        }
        return map;
    }
}
